package com.yeahliving.goalhome.ims.dao;

import com.yeahliving.goalhome.ims.bean.GoHoRoom;

/**
 * Created by xingfeiy on 9/30/15.
 */
public interface RoomMapper {
    public GoHoRoom getByID(int id);

    public void add(GoHoRoom room);
}
