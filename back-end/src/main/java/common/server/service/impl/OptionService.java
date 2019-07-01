package common.server.service.impl;

import common.server.domain.Option;
import common.server.exception.NotFoundException;
import common.server.repository.OptionRepository;
import common.server.service.IOptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OptionService implements IOptionService {

    @Autowired
    private OptionRepository repo;

    @Override
    public Option add(Option option) {
        return repo.save(option);
    }

    @Override
    public Option findById(long id) throws NotFoundException {
        if (!repo.existsById(id))
            throw new NotFoundException("OPTION.NOT.FOUND", "Option not found with id : " + id);
        return repo.findById(id).get();
    }

    @Override
    public List<Option> findAll() {
        return repo.findAll();
    }

    @Override
    public void delete(long id) throws NotFoundException {
        if (!repo.existsById(id))
            throw new NotFoundException("OPTION.NOT.FOUND", "Option not found with id : " + id);
        repo.deleteById(id);
    }

}