package comg.github.technus.iarWiggler.xml.adapters;

import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import java.util.Objects;

public class YeetAdapter extends CollapsedStringAdapter {
    @Override
    public String unmarshal(String text) {
        text=super.unmarshal(text);
        return Objects.equals("",text)?null:text;
    }
}
