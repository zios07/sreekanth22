package common.server.service;

import common.server.domain.Option;
import common.server.exception.NotFoundException;

import java.util.List;

public interface IOptionService {

	Option add(Option option);

	Option findById(long id) throws NotFoundException;

	List<Option> findAll();

	void delete(long id) throws NotFoundException;

}
