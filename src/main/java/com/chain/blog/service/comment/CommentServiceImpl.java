package com.chain.blog.service.comment;

import com.chain.blog.dao.CommentDao;
import com.chain.blog.entity.Comment;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * @author: chain
 * @create: 2020/01/31
 **/
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Value("${comment.avatar}")
    private String avatar;

    @Override
    public List<Comment> listCommentByBlogId(int blogId) {
        List<Comment> allComments=allComments(blogId);
        if (allComments.size()==0)
            return new ArrayList<Comment>();
        return getWholeCommentTreeAdvanced(allComments);
//        return commentDao.listCommentByBlogId(blogId);
    }

    @Override
    public int saveComment(Comment comment) {
        if (comment.getAvatar()==null)
        comment.setAvatar(avatar);
        comment.setCreateTime(new Date());
        return commentDao.saveComment(comment);

    }

    @Override
    public List<Comment> firstParentComment(int blogId) {
        return null;
    }


    /**
     * 根据博客id返回该博客的所有子评论
     * @param blogId
     * @return
     */
    public List<Comment> blogSonComment(int blogId){
        return commentDao.getAllBlogSonComment(blogId);
    }

    /**
     * 根据博客id返回该博客下所有评论
  * @param blogId
     * @return
     */
    public List<Comment> allComments(int blogId){
        return commentDao.listCommentByBlogId(blogId);
    }

    /**
     * 处理评论逻辑
     * @param comments
     * @return
     */
    public List<Comment> dealComments(List<Comment> comments){
        List<Comment> roots=new ArrayList<>() ;
        for (Comment comment:comments) {
           if (comment.getParentCommentId()==-1&&!roots.contains(comment)){
               roots.add(comment);
           }
        }
        int i=0;
        for (Comment comment:roots){
            i++;
            List<Integer> ids=new ArrayList<>();//存放该链的所有id
            List<Comment> rootReply=new ArrayList<>();
            ids.add(comment.getId());
            for (Comment commentson:comments){
                if (ids.contains(commentson.getParentCommentId())&&!rootReply.contains(commentson)){
                    ids.add(commentson.getId());
                    rootReply.add(commentson);
                }
            }
            comment.setReplyComments(sortRC( rootReply ));
            if (i==roots.size()-1){
                //执行完成 comments不存在剩余
            }
        }
        return roots;
    }

    /**  废弃
     * 冒泡
     * 根据子结点的父节点的id进行排序
     * 取出的子结点以按时间顺序排序
     * 父节点id越小 子结点越靠前 父id相同时按时间排序
     * @param comments 根父节点的所有子结点
     * @return 排序的子结点
     */
    public List<Comment> sortReplyComments(List<Comment> comments) {
        Comment[] comments_array = (Comment[]) comments.toArray();
        Comment temp = null;
        Comment current;
        Comment next;
        int i = 0, j = 0;
        int length = comments_array.length;
        for (; i < length - 1; i++) {
            current = comments_array[i];
            for (j = i + 1; j < length; j++) {
                current = comments_array[i];
                next = comments_array[j];
                if ((current.getParentCommentId() > next.getParentCommentId())
                        || (current.getParentCommentId() == next.getParentCommentId() && current.getCreateTime().after(next.getCreateTime()))) {
                    temp = current;
                    comments_array[i] = comments_array[j];
                    comments_array[j] = temp;
                }
            }
        }
        return Arrays.asList(comments_array);
    }

        //废弃
    public List<Comment> sortRC(List<Comment> comments){


             Collections.sort(comments, new Comparator<Comment>() {
             @Override
//            arg0-arg1就是升序排序
            public int compare(Comment o1, Comment o2) {
                if (o1.getParentCommentId()>o2.getParentCommentId()){
                    return 1;
                }
                return 0;
            }
        });
             return comments;

    }

    /**
     * 得到评论树根
     * @param rootComment 树根
     * @param comments 所有评论集
     * @return 返回带有叶子的树根
     */
        List<Comment> treeComments=new ArrayList<>();//中间容器
    public Comment getCommentTree(Comment rootComment , List<Comment> comments){
        //树根处理
        if(rootComment.getParentCommentId()==-1&&theFirstSonComment(rootComment,comments)==null){

            return rootComment;
        }
        Comment startComment=theFirstSonComment(rootComment,comments);
        if(startComment==null){
            treeComments.add(rootComment);
            comments.remove(rootComment);
            getCommentTree(rootComment.getParentComment(),comments);
        }

        else         getCommentTree(startComment,comments);


//        if(!hasSon(startComment,comments)){
//            treeComments.add(startComment);
//            comments.remove(startComment);
//        }

        return rootComment;

    }
    /**
     * 判断 一个评论是否有子评论
     * @param comment
     * @param comments 所有评论集
     * @return true 有
     */
    public Boolean hasSon(Comment comment ,List<Comment> comments){
        for (Comment comm:comments
             ) {
            if(comment.getId()==comm.getParentCommentId())
            return true;
        }
        return  false;
    }

    /**
     * 返回一个评论的最早子评论
     * @param comment
     * @param comments
     * @return
     */
    public Comment theFirstSonComment(Comment comment ,List<Comment> comments){
        for (Comment comm:comments
        ) {
            if(comment.getId()==comm.getParentCommentId())
                return comm;
        }
        return  null;
    }

    /**
     * 评论森林
     * @param blogId
     * @return
     */
    public List<Comment> getTheWholeCommentTreeOfBlog(List<Comment> allComments){

        List<Comment> roots=new ArrayList<>() ;//树根集合
        for (Comment comment:allComments) {
            if (comment.getParentCommentId()==-1&&!roots.contains(comment)){
                roots.add(comment);
            }
        }
        for (Comment root : roots
             ) {
            getCommentTree(root,allComments);
            List<Comment> comments=new ArrayList<>();
            comments.addAll(treeComments);
            System.out.println("清空前"+comments);
            treeComments.clear();
            System.out.println("later:"+comments);
            root.setReplyComments(comments);

        }
        return roots;

    }


    /**
     *
     */
    List<Comment> atreeComments=new ArrayList<>();
    public Comment getSingleTreeComment(Comment treeComment,List<Comment> allComments){

        if ((!hasSon(treeComment,allComments)&&treeComment.getParentCommentId()==-1)||allComments.size()==0){
            treeComment.setReplyComments(atreeComments);
            return treeComment;
        }

        if(!atreeComments.contains(treeComment)){
            atreeComments.add(treeComment);

        }
        allComments.remove(treeComment);
        Comment sonComment=theFirstSonComment(treeComment,allComments);
        if(sonComment ==null ){
            return getSingleTreeComment(treeComment.getParentComment(),allComments);

        }
        return          getSingleTreeComment(sonComment,allComments);

    }



    List<Comment> btreeComments=new ArrayList<>();
    public void getVoidSingleTreeComment(Comment treeComment,List<Comment> allComments){
        //终止条件
        if (!hasSon(treeComment,allComments)&&treeComment.getParentCommentId()==-1){
            return;
        }
        if (!btreeComments.contains(treeComment)){
            btreeComments.add(treeComment);
        }
        allComments.remove(treeComment);
        Comment sonComment=theFirstSonComment(treeComment,allComments);
        if (sonComment==null){
            getVoidSingleTreeComment(treeComment.getParentComment(),allComments);
        }else {
            getVoidSingleTreeComment(sonComment,allComments);
        }
    }

    public List<Comment> getBtreeComments() {
        return btreeComments;
    }

    /**
     * 返回评论树根集合
     * @param comments 所有评论
     * @return
     */
    public List<Comment> getWholeCommentTreeAdvanced(List<Comment> comments){
        List<Comment> roots=new ArrayList<>() ;
        for (Comment comment:comments) {
            if (comment.getParentCommentId()==-1&&!roots.contains(comment)){
                roots.add(comment);
            }
        }
        for (Comment root : roots){
            List<Comment> temp=new ArrayList<>() ;
            btreeComments.clear();
            getVoidSingleTreeComment(root,comments);
            if (btreeComments.size()>=1) {
                btreeComments.remove(btreeComments.get(0));
                temp.addAll(btreeComments);
            }
            root.setReplyComments(temp);
            btreeComments.clear();
        }

        return roots;
    }
}
