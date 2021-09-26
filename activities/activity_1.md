# Activity 1

## 🗺 Exploration

## 🔎 Exercise 1.1 - Exploring the Code

For this exercise, spend some time familarising yourself with the code.mvn 
  
- Part of your journey to becoming a great Software Engineer
  is being able to read and understand code, as well as writing it.
- As children, we learn to read and speak in a language while we're learning how
  to write it; the same can be said about Software Engineering.

- 📖 So, flex those reading muscles! 💪

```
💡 Top Tip: Try looking at the README file first.
  Diagramming / sketching things out can be a handy way of
visualising a codebase that you haven't seen before. It can help you
  focus on the key information rather than getting lost in the details
  too soon.
```
  
---

## 🔎 Exercise 1.2 - Questions

- What is a Test Double?

<details>
<summary>Click here to see the answer</summary>
<pre>

A test double is any kind of pretend object used in place of a real object for testing purposes.

</pre>
</details>

---

- In the [test](../src/test) folder, can you identify the name of the file
  that contains the class that represents the test double type, 'Dummy'?

<details>
<summary>Click here to see the answer</summary>
<pre>

DummySimpleLogger.java

</pre>
</details>

---

- In the [test](../src/test) folder, can you identify the name of the file
  that contains the class that represents the test double type, 'Stub'?

<details>
<summary>Click here to see the answer</summary>
<pre>

RandomStub.java

</pre>
</details>

---

- Look at the [BubbleTeaOrderService](../src/main/java/com/techreturners/bubbleteaordersystem/service/BubbleTeaOrderService.java)
  class. What two dependencies are being injected into the constructor?

<details>
<summary>Click here to see the answer</summary>
<pre>

- An object of type `SimpleLoggerImpl`
- An object of type `BubbleTeaMessenger`

</pre>
</details>

---

- What types of Bubble Tea does the [BubbleTeaTypeEnum](../src/main/java/com/techreturners/bubbleteaordersystem/model/BubbleTeaTypeEnum.java) have?

<details>
<summary>Click here to see the answer</summary>
<pre>

OolongMilkTea 
JasmineMilkTea
MatchaMilkTea
PeachIceTea
LycheeIceTea

</pre>
</details>

---

- What does Encapsulation mean from the four pillars of Object-Oriented Programming?

<details>
<summary>Click here to see the answer</summary>
<pre>

Encapsulation means hiding the details of an object which is not supposed to be open for interaction publicly.

</pre>
</details>

---

- In the [DebitCard](../src/main/java/com/techreturners/bubbleteaordersystem/model/DebitCard.java) class,
  can you identify which line of code represents the `getter`?
  
<details>
<summary>Click here to see the answer</summary>
<pre>

DebitCard - Line 11

```

public String getDigits() {
  return this.DIGITS;
}

```

The getter `getDigits` has a private backing field `private final String DIGITS;`

This keeps the class well-encapsulated, so that the Debit Card Digits won't be tampered with
after it's been set by the constructor.

</pre>
</details>

---

### 🥳 Yay! Next Steps

You can now head over to [Activity 2 - Test Doubles - Dummy](activity_2.md).
Remember to take a break though 🍵, you totally deserve it!
