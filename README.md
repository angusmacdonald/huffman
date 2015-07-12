# Java 8 Huffman Coding Implementation

[![Build Status](https://travis-ci.org/angusmacdonald/huffman.svg)](https://travis-ci.org/angusmacdonald/huffman)
[![Coverage Status](https://coveralls.io/repos/angusmacdonald/huffman/badge.svg?branch=master)](https://coveralls.io/r/angusmacdonald/huffman?branch=master)
![](https://reposs.herokuapp.com/?path=angusmacdonald/huffman)
[![License](http://img.shields.io/:license-mit-blue.svg)](http://gus.mit-license.org/)

Toy project implementing a Huffman Encoder using Java 8 and Dagger 2.

I created it as an exercise in using Java 8 constructs, which you can see most prominently in the `Encoder` and `FrequencyDistribution` classes.

The project uses Dagger 2 to manage some very basic dependencies. All of the Dagger 2 dependencies are in maven, but if you want to run the code in eclipse (or another IDE) you'll need to set up annotation processing ([as seen here](https://immutables.github.io/apt.html), and create a `target/generated-sources/annotations` source directory.

## Running the Encoder

The `HuffmanEncoder` class should be called to encode a message. The result of the `encode()` call is a `EncodingResult` object which contains both the encoded result and the encoding tree required to decode the message again.

## Structure

The encoder stores the result of encoding each character in a `BitSet` which is is converted into a byte array before being stored into `EncodingResult`.