package com.mowitnow.driver.mapper;

import com.mowitnow.driver.model.Action;
import com.mowitnow.driver.utils.Validator;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import static com.mowitnow.driver.shared.Constant.REGEX_ACTION;
import static com.mowitnow.driver.shared.Message.EXCEPTION_INVALID_ACTION;
import static com.mowitnow.driver.shared.Message.EXCEPTION_MISSING_ACTION;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ActionMapper {

  public static List<Action> parseFromLine(String line) {
    if (Validator.isNullOrEmpty(line)) throw new IllegalArgumentException(EXCEPTION_MISSING_ACTION);
    if (Validator.isInvalidLine(line, REGEX_ACTION))
      throw new IllegalArgumentException(EXCEPTION_INVALID_ACTION);

    List<Action> actionList = new ArrayList<>();

    for (char current : line.toCharArray()) {
      var currentAction = Action.valueOf(String.valueOf(current));
      actionList.add(currentAction);
    }
    return actionList;
  }
}
