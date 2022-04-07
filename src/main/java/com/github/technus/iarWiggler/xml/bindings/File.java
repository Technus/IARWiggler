package com.github.technus.iarWiggler.xml.bindings;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlType(name = "file")
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
@EqualsAndHashCode
public class File {
    public String name;
    @XmlElement(name = "excluded")
    public Exclusions exclusions;
    @XmlElement(name = "configuration",type = Configuration.class)
    public ArrayList<Configuration> configurations = new ArrayList<>();
}
