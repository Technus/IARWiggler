package comg.github.technus.iarWiggler.xml.bindings;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlType(name = "option")
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
@EqualsAndHashCode
public class Option {
    public String name;
    public String version;
    public ArrayList<String> state = new ArrayList<>();
}
