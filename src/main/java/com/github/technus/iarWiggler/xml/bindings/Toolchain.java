package com.github.technus.iarWiggler.xml.bindings;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "toolchain")
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
@EqualsAndHashCode
public class Toolchain {
    public String name;
}
