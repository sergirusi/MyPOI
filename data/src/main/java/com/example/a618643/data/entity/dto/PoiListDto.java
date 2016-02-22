package com.example.a618643.data.entity.dto;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Created by a618643 on 03/02/2016.
 */
public class PoiListDto {

    @Expose
    private List<PoiDto> list;

    public PoiListDto() {
    }

    public PoiListDto(List<PoiDto> list) {
        this.list = list;
    }

    public List<PoiDto> getList() {
        return list;
    }

    public PoiDto getPoiFromList(int index) {
        return list.get(index);
    }

    public void setList(List<PoiDto> list) {
        this.list = list;
    }

}
