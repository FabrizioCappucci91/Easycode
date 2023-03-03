package com.pawtropolis.console;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
@Slf4j
public class InputController {
  private InputController(){}
  public static String readString() {
    InputStreamReader input = new InputStreamReader(System.in);
    BufferedReader inputReader = new BufferedReader(input);
    try {
      return inputReader.readLine();
    } catch (IOException e) {
      log.error("Error while reading user input");
      return "";
    }
  }
}
