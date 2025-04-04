import com.techreturners.bubbleteaordersystem.model.*;
import com.techreturners.bubbleteaordersystem.service.BubbleTeaMessenger;
import com.techreturners.bubbleteaordersystem.service.BubbleTeaOrderService;

import com.techreturners.bubbleteaordersystem.service.BubbleTeaRouletteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import testhelper.DummySimpleLogger;
import testhelper.RandomStub;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class BubbleTeaOrderServiceTest {

    private DebitCard testDebitCard;
    private PaymentDetails paymentDetails;
    private DummySimpleLogger dummySimpleLogger;
    private BubbleTeaMessenger mockMessenger;
    private BubbleTeaOrderService bubbleTeaOrderService;


    @RunWith(Parameterized.class)
    public class BubbleTeaOrderServiceSpyTest {

        private DebitCard testDebitCard;
        private BubbleTeaMessenger spiedMessenger;
        private BubbleTeaOrderService bubbleTeaOrderService;

        @Parameterized.Parameter(0)
        public String teaType;
        @Parameterized.Parameter(1)
        public double price;

        @Parameterized.Parameters(name = "{index}: Test with teaType = {0}, price = {1} ")
        public static Collection<Object[]> data() {
            Object[][] data = new Object[][]{{"OolongMilkTea", 2.50}, {"JasmineMilkTea", 3.15}, {"MatchaMilkTea", 4.20}, {"PeachIceTea", 2.80}, {"LycheeIceTea", 3.50}};
            return Arrays.asList(data);
        }


        @BeforeEach
        public void setup() {
            testDebitCard = new DebitCard("0123456789");
            paymentDetails = new PaymentDetails("hello kitty", "sanrio puroland", testDebitCard);
            dummySimpleLogger = new DummySimpleLogger();
            mockMessenger = mock(BubbleTeaMessenger.class);
            bubbleTeaOrderService = new BubbleTeaOrderService(dummySimpleLogger, mockMessenger);
        }

        @Test
        public void shouldCreateBubbleTeaOrderRequestWhenCreateOrderRequestIsCalled() {

            //Arrange
            BubbleTea bubbleTea = new BubbleTea(BubbleTeaTypeEnum.OolongMilkTea, 4.5);
            BubbleTeaRequest bubbleTeaRequest = new BubbleTeaRequest(paymentDetails, bubbleTea);

            BubbleTeaOrderRequest expectedResult = new BubbleTeaOrderRequest(
                    "hello kitty",
                    "sanrio puroland",
                    "0123456789",
                    BubbleTeaTypeEnum.OolongMilkTea
            );

            //Act
            BubbleTeaOrderRequest result = bubbleTeaOrderService.createOrderRequest(bubbleTeaRequest);

            //Assert
            assertEquals(expectedResult.getName(), result.getName());
            assertEquals(expectedResult.getAddress(), result.getAddress());
            assertEquals(expectedResult.getDebitCardDigits(), result.getDebitCardDigits());
            assertEquals(expectedResult.getBubbleTeaType(), result.getBubbleTeaType());

            //Verify Mock was called with the BubbleTeaOrderRequest result object
            verify(mockMessenger).sendBubbleTeaOrderRequestEmail(result);
            verify(mockMessenger, times(1)).sendBubbleTeaOrderRequestEmail(result);
        }
    }

}


