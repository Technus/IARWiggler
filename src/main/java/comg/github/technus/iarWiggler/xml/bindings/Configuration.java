package comg.github.technus.iarWiggler.xml.bindings;

import comg.github.technus.iarWiggler.xml.adapters.YeetAdapter;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;

@XmlType(name = "configuration")
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
@EqualsAndHashCode
public class Configuration {
    @XmlMixed
    @XmlJavaTypeAdapter(YeetAdapter.class)
    public List<String> value = new ArrayList<>();
    public String name;
    public Toolchain toolchain;
    public String debug;
    @XmlElement(type = Settings.class)
    public ArrayList<Settings> settings = new ArrayList<>();
}
