package dev.patika.vetproject.core.utilities;

import dev.patika.vetproject.core.result.Result;
import dev.patika.vetproject.core.result.ResultData;
import dev.patika.vetproject.dto.response.CursorResponse;

public class ResultHelper {

    public static <T>ResultData<T> created (T data){

        return new ResultData<>(true,Msg.CREATED, "201", data);
    }


    public static <T> ResultData<T> validateError (T data) {
        return new ResultData<>(false, Msg.VALIDATE_ERROR,"400", data);
    }

    public static <T>ResultData<T> success (T data){

        return new ResultData<>(true,Msg.OK, "209", data);
    }

    public static Result notFoundError (String msg) {
        return new Result (false, msg,"404");
    }

    public static Result ok () {
        return new Result(true,Msg.OK,"200");
    }



    /*
    public static <T> ResultData<CursorResponse<T>> cursor (T data, ) {
        CursorResponse<T> cursor = new CursorResponse<>();
        cursor.setItems(pageData.getContent());
        cursor.setPageNumber(pageData.getNumber());
        cursor.setPageSize(pageData.getSize());
        cursor.setTotalElements(pageData.getTotalElements());

        return ResultHelper.success(cursor);
    }

*/
}
