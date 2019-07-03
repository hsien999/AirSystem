package cn.wyx.entity;

import java.io.Serializable;

/**
 *机型
 */
public class Model implements Serializable {
    /**
     *机型编号
     */
    private Long modelId;
    /**
     *机型名称
     */
    private String modelName;
    /**
     *速度（公里/小时）
     */
    private int modelSpeed;

    public Model() {
    }

    public Model(Long modelId, String modelName, int modelSpeed) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.modelSpeed = modelSpeed;
    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getModelSpeed() {
        return modelSpeed;
    }

    public void setModelSpeed(int modelSpeed) {
        this.modelSpeed = modelSpeed;
    }

    @Override
    public String toString() {
        return "Model{" +
                "modelId=" + modelId +
                ", modelName='" + modelName + '\'' +
                ", modelSpeed=" + modelSpeed +
                '}';
    }
}
