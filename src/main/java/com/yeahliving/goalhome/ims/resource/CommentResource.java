package com.yeahliving.goalhome.ims.resource;

import com.yeahliving.goalhome.ims.bean.GoHoComment;
import com.yeahliving.goalhome.ims.dao.CommentMapper;
import com.yeahliving.goalhome.ims.service.GoHoObjService;
import com.yeahliving.goalhome.ims.service.response.GoHoObjResponse;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

/**
 * Created by xingfeiy on 10/9/15.
 */
@Path("comment")
public class CommentResource {
    public GoHoObjResponse add(@QueryParam("entity_code") int entity_code,
                               @QueryParam("entity_id") int entity_id,
                               @QueryParam("comments") String comments,
                               @QueryParam("uid") int uid) {
        GoHoComment comment = new GoHoComment();
        comment.setEntity_id(entity_id);
        comment.setEntity_code(entity_code);
        comment.setComments(comments);
        comment.setUid(uid);
        return GoHoObjService.add(comment, CommentMapper.class);
    }
}
