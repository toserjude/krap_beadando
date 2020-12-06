package uni.eszterhazy.krap.exceptions;

public class RosszKobcenti extends Throwable {
    public RosszKobcenti(double fizetes) {
        super(String.valueOf(fizetes));
    }
}
