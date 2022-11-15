package com.training.SpringREST.Entity;

public class Car {

    String modelId;
    String modelName;
    int modelReleased;
    String color;
    String fuelType;

    Car(){

    }

    public Car(String modelId, String modelName, int modelReleased, String color, String fuelType) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.modelReleased = modelReleased;
        this.color = color;
        this.fuelType = fuelType;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getModelReleased() {
        return modelReleased;
    }

    public void setModelReleased(int modelReleased) {
        this.modelReleased = modelReleased;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "modelId='" + modelId + '\'' +
                ", modelName='" + modelName + '\'' +
                ", modelReleased=" + modelReleased +
                ", color='" + color + '\'' +
                ", fuelType='" + fuelType + '\'' +
                '}';
    }
}
