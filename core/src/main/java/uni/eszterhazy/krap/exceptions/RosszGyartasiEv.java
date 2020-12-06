package uni.eszterhazy.krap.exceptions;

public class RosszGyartasiEv extends Throwable {
    public RosszGyartasiEv(int s) {
        super(String.valueOf(s));
    }
}
