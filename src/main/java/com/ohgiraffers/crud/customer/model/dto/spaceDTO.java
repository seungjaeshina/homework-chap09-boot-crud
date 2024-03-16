package com.ohgiraffers.crud.customer.model.dto;

public class spaceDTO {

    private  int categoryNo;
    private String categoryName;
    private int roomCode;

    public spaceDTO() {
    }

    public spaceDTO(int categoryNo, String categoryName, int roomCode) {
        this.categoryNo = categoryNo;
        this.categoryName = categoryName;
        this.roomCode = roomCode;
    }

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(int roomCode) {
        this.roomCode = roomCode;
    }

    @Override
    public String toString() {
        return "spaceDTO{" +
                "categoryNo=" + categoryNo +
                ", categoryName='" + categoryName + '\'' +
                ", roomCode=" + roomCode +
                '}';
    }
}
