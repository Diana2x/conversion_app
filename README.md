<h1 align="center">💸 Conversion Tool App 💸</h1>

<p align="center">
The Conversion Tool App is a Java application that allows users to convert currencies and temperatures. It provides an intuitive graphical user interface (GUI) for easy conversion and displays accurate results.
</p>

<h2 align="center"> Features </h2>

Currency Converter: Convert between different currencies using real-time exchange rates fetched from an API.
Temperature Converter: Convert temperatures between Celsius, Fahrenheit, and Kelvin.

<h2 align="center"> Installation </h2>

Clone the repository to your local machine using the following command:
bash
Copy code
git clone
Open the project in your Java IDE (e.g., Eclipse, IntelliJ).

<h2 align="center">Usage</h2>

Replace "apiKey" with your actual API key in the CurrencyRatesAPI class. You can obtain a free key [here](https://app.exchangerate-api.com/).
Launch the app by running the Main class.

<code>
cd conversion-tool/src
javac *.java
java Main
</code>

<h2 align="center"> 💶 Currency Converter 💶 </h2>

Enter the amount to be converted in the "Amount" field.
Select the currency from which you want to convert in the "From" dropdown.
Select the currency to which you want to convert in the "To" dropdown.
Click the "Convert" button to see the converted latest value and exchange rate fetched from an API.

<p align="center">
  <img src="https://media.giphy.com/media/6Yw3kg6lu02j5HI9kC/giphy.gif" alt="Currency Converter Preview">
</p>

<h2 align="center"> 🌡️ Temperature Converter 🌡️ </h2>

Select the temperature scale you want to convert from in the "From" dropdown.
Select the temperature scale you want to convert to in the "To" dropdown.
Enter the temperature value you want to convert in the input field.
Click the "Convert" button to see the converted temperature.

<p align="center">
  <img src="https://media.giphy.com/media/nw0nRsOpBEtO3pja8d/giphy.gif" alt="Temperature Converter Preview">
</p>

<h2 align="center"> Dependencies </h2>

The app uses the following external dependencies:

JSON: A JSON parser and generator for Java. (Used for parsing API responses.)
API Usage
The Currency Converter fetches real-time exchange rates from an API.
