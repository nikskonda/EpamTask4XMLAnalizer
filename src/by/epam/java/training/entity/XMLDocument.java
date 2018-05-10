package by.epam.java.training.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class XMLDocument implements Serializable, Iterable {

    private static final long serialVersionUID = 1L;

    private String docName;
    private List<TagUnit> tagUnitList;

    public XMLDocument() {
    }

    public XMLDocument(String docName) {
        this.docName = docName;
        this.tagUnitList = new ArrayList<>();
    }

    public XMLDocument(String docName, List<TagUnit> tagUnitList) {
        this.docName = docName;
        this.tagUnitList = tagUnitList;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public int getSizeTagUnitList(){
        return this.tagUnitList.size();
    }

    public List<TagUnit> getTagUnitList() {
        return tagUnitList;
    }

    public TagUnit getTagUnit(int index){
        return this.tagUnitList.get(index);
    }

    public void setTagUnitList(List<TagUnit> tagUnitList) {
        this.tagUnitList = tagUnitList;
    }

    public void setTagUnit(int index, TagUnit tagUnit){
        this.tagUnitList.set(index, tagUnit);
    }

    public void addTagUnit(TagUnit tagUnit){
        this.tagUnitList.add(tagUnit);
    }

    public void addTagUnitList(List<TagUnit> list){
        for (TagUnit tagUnit : list){
            this.tagUnitList.add(tagUnit);
        }
    }

    @Override
    public Iterator iterator() {
        return this.tagUnitList.iterator();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        XMLDocument xmlDocument = (XMLDocument) obj;

        if (!this.docName.equals(xmlDocument.getDocName())){
            return false;
        }
        if (!this.tagUnitList.equals(xmlDocument.getTagUnitList())){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode += this.docName.hashCode();
        hashCode += this.tagUnitList.hashCode();
        return  hashCode;
    }
}
