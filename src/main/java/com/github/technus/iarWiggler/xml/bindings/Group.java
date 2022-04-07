package com.github.technus.iarWiggler.xml.bindings;

import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.stream.Stream;

@XmlType(name = "group")
@XmlAccessorType(XmlAccessType.FIELD)
@ToString(exclude = "parent")
@EqualsAndHashCode(callSuper = true)
public class Group extends File {
    @XmlElement(name = "file",type = File.class)
    public ArrayList<File> files = new ArrayList<>();
    @XmlElement(name = "group",type = Group.class)
    public ArrayList<Group> groups = new ArrayList<>();

    @XmlTransient
    public Group parent;

    public Stream<Group> flatten(){
        groups.forEach(group -> group.parent=this);
        return Stream.concat(Stream.of(this),groups.stream().flatMap(Group::flatten));
    }

    public String path(){
        return (parent!=null)?parent.path()+"\\"+name:name;
    }
}
