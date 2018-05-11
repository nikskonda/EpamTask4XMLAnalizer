package by.epam.java.training.entity;

import java.util.Objects;

public class TagUnit {

    private static final long serialVersionUID = 1L;

    private TagType tagType;
    private String value;

    public TagUnit() {
    }

    public TagUnit(TagType tagType, String value) {
        this.tagType = tagType;
        this.value = value;
    }

    public TagType getTagType() {
        return tagType;
    }

    public void setTagType(TagType tagType) {
        this.tagType = tagType;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TagUnit tagUnit = (TagUnit) obj;

        if (!this.tagType.equals(tagUnit.tagType)){
            return false;
        }
        if (!this.value.equals(tagUnit.value)){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 0;
        hashCode += this.tagType.hashCode();
        hashCode += this.value.hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.tagType.toString()).append(": ").append(this.value);
        return sb.toString();
    }
}
