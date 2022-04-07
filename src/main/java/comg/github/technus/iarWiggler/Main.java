package comg.github.technus.iarWiggler;

import lombok.SneakyThrows;
import lombok.val;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        val iar=new IARModel(new java.io.File("").toPath());
    }
}