package cn.chen.service;

import cn.chen.dao.HeadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 管理用户头像信息
 */
@Service("imgService")
public class ImgService {
    @Autowired
    HeadDao headDao;

    public byte[] getImg(int id){
        System.out.println("getImg");
        byte[]img=headDao.getImg(id);
        return img;
    }
    public void saveImg(int id,byte[]img){
        System.out.println("save");
        if(headDao.hasId(id)<1){
            headDao.save(id,img);
        }else {
            headDao.update(id, img);
        }
    }
    public boolean hasId(int id){
        if(headDao.hasId(id)<1){
            return false;
        }else {
            return true;
        }
    }
}
