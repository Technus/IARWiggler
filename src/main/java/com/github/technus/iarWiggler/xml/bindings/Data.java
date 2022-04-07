package com.github.technus.iarWiggler.xml.bindings;

import com.github.technus.iarWiggler.xml.adapters.YeetAdapter;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;

@XmlType(name = "data")
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
@EqualsAndHashCode
public class Data {
    @XmlMixed
    @XmlJavaTypeAdapter(YeetAdapter.class)
    public ArrayList<String> value=new ArrayList<>();
    public String version;
    public String wantNonLocal;
    public String debug;
    @XmlElement(name = "option",type = Option.class)
    public ArrayList<Option> options = new ArrayList<>();
    public String extensions;
    public String cmdline;
    public String hasPrio;
    public String prebuild;
    public String postbuild;
}
