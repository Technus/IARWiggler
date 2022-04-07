package com.github.technus.iarWiggler.xml.bindings;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlType(name = "project")
@XmlRootElement(name = "project")
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
@EqualsAndHashCode
public class Project {
    public String fileVersion;
    @XmlElement(name = "configuration",type = Configuration.class)
    public ArrayList<Configuration> configurations = new ArrayList<>();
    @XmlElement(name = "group",type = Group.class)
    public ArrayList<Group> groups = new ArrayList<>();
    @XmlElement(name = "file",type = File.class)
    public ArrayList<File> files = new ArrayList<>();
}
