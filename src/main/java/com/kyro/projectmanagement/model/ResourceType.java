package com.kyro.projectmanagement.model;

public enum ResourceType {
    File("File", "File");

    private final String code;
    private final String desc;

    ResourceType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
