# Caesar Cipher

This Java application implements the Caesar cipher encryption and decryption algorithm.

## Overview

The `Caesar` class provides methods for encryption and decryption using the Caesar cipher algorithm.

## Usage

### Encryption and Decryption

To use the Caesar cipher for encryption or decryption:

1. Create an instance of the `Caesar` class.
2. Call the `caesarEncryption` method with the input and output files, deviation, and encryption mode (true for encryption, false for decryption).

Example:

```java
Caesar caesar = new Caesar();
File inputFile = new File("input.txt");
File outputFile = new File("output.txt");
int deviation = 3; // specify the deviation
boolean isEncryption = true; // true for encryption, false for decryption

// Encrypt the message from input.txt and write to output.txt
caesar.caesarEncryption(inputFile, outputFile, deviation, isEncryption);
