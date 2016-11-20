package ua.com.mybox.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.com.mybox.entity.Producer;
import ua.com.mybox.repository.ProducerRepository;
import ua.com.mybox.service.ProducerService;

@Service
public class ProducerServiceImpl implements ProducerService {

	@Autowired
	private ProducerRepository producerRepository;
	
	
	public void save(Producer producer) {
	producerRepository.save(producer);
		
	}

	public List<Producer> findAll() {
		
		return producerRepository.findAll();
	}

	public Producer findOne(int id) {
		
		return producerRepository.findOne(id);
	}

	public void delete(int id) {
		producerRepository.delete(id);
		
	}
	@Override
	public List<Producer> allFetch() {
		
		return producerRepository.findAllByFetch();
	}

}
