<h1 align="center">💸 Conversion Tool App 💸</h1>

<p align="center">
The Conversion Tool App is a Java application that allows users to convert currencies and temperatures. It provides an intuitive graphical user interface (GUI) for easy conversion and displays accurate results.
</p>

<h2 align="center"> Features </h2>

<p>Currency Converter: Convert between different currencies using real-time exchange rates fetched from an API.
Temperature Converter: Convert temperatures between Celsius, Fahrenheit, and Kelvin.
</p>

<h2 align="center"> Getting Started </h2>
<p>
To use this project, you will need to set up an environment configuration file (env file) that stores your API key. This is necessary for the project to work correctly. Here's how you can do it:

Create a new file in the root directory of the project and name it .env.
Open the .env file using a text editor of your choice.
Add the following line to the file:
<code>
API_KEY=YOUR_API_KEY_HERE
</code>

You can obtain a free API key [here](https://app.exchangerate-api.com/).
</p>



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
