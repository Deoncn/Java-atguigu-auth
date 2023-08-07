package com.atguigu.system.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:GuiguException
 * Package: IntelliJ IDEA
 * Description:
 *
 * @ Author: Deoncn
 * @ Create: 2023/7/14 - 20:44
 * @ Version: v1.0
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GuiguException extends RuntimeException{

  private Integer code;
  private String msg;

}
