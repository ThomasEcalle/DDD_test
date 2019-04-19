package common.response;

/**
 * User: thomasecalle
 * Date: 19/04/2019
 * Time: 15:12
 */
public class Response<T> {

    private RuntimeException error;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public RuntimeException getError() {
        return error;
    }

    public void setError(RuntimeException error) {
        this.error = error;
    }
}
