package top.nilaoda.apps.cms.service.impl;

import top.nilaoda.apps.cms.bean.Comment;
import top.nilaoda.apps.cms.bean.CommentExample;
import top.nilaoda.apps.cms.mapper.CommentMapper;
import top.nilaoda.apps.cms.mapper.extend.CommentExtendMapper;
import top.nilaoda.apps.cms.service.CommentService;
import top.nilaoda.apps.cms.util.PageVM;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;
    @Resource
    private CommentExtendMapper commentExtentMapper;

    @Override
    public List<Comment> findAll() {
        return commentMapper.selectByExample(null);
    }

    @Override
    public List<Comment> findByContent(String content) {
        CommentExample commentExample = new CommentExample();
        commentExample.createCriteria().andContentLike("%" + content + "%");
        return commentMapper.selectByExample(commentExample);
    }

    @Override
    public Comment findById(long id) {
        return commentMapper.selectByPrimaryKey(id);
    }

    @Override
    public long saveOrUpdate(Comment comment) {
        if (comment.getId() == null) {
            return commentMapper.insert(comment);
        } else {
            return commentMapper.updateByPrimaryKey(comment);
        }
    }

    @Override
    public long deleteById(long id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageVM<Comment> pageQuery(int page, int pageSize) {
        List<Comment> data = commentExtentMapper.pageQuery(page, pageSize);
        PageVM<Comment> pageVM = new PageVM<>();
        pageVM.setList(data);
        pageVM.setPage(page);
        pageVM.setPageSize(pageSize);
        pageVM.setTotal(commentExtentMapper.queryTotalCount());
        return pageVM;
    }
}
