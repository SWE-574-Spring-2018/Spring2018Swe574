package com.linkyway.service;

import com.linkyway.mapper.NodeEntityMapper;
import com.linkyway.model.entity.Node;
import com.linkyway.model.exception.NoMatchingNodeFoundException;
import com.linkyway.model.exception.NodeAlreadyExistsException;
import com.linkyway.repository.NodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author huseyin.kilic
 */
@Service
@Transactional
public class NodeService {

    @Autowired
    private NodeEntityMapper entityMapper;

    @Autowired
    private NodeRepository nodeRepository;


    public com.linkyway.model.domain.Node getNodeByTypeAndName(String type, String name) throws NoMatchingNodeFoundException {
        Node foundNode = nodeRepository.findByTypeAndName(type, name);
        if (foundNode == null) {
            throw new NoMatchingNodeFoundException(type, name);
        }
        return entityMapper.convert(foundNode);
    }

    public List<com.linkyway.model.domain.Node> getAllNodes() {
        List<Node> nodes = nodeRepository.retrieveAll();
        return entityMapper.convert(nodes);
    }

    public com.linkyway.model.domain.Node createNode(com.linkyway.model.domain.Node node) throws NodeAlreadyExistsException {
        Node existingNode = nodeRepository.findByTypeAndName(node.getType(), node.getName());
        if (existingNode != null) {
            throw new NodeAlreadyExistsException(existingNode.getId());
        }

        Node entity = entityMapper.convert(node);
        return entityMapper.convert(nodeRepository.create(entity));
    }

    public void deleteNode(Long id) {
        nodeRepository.delete(id);
    }

}
