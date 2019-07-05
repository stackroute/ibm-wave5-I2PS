package com.stackroute.service;

import com.stackroute.domain.Idea;
import com.stackroute.repository.IdeaHubRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdeaHubServiceImpl implements IdeaHubService {
  IdeaHubRepository ideaHubRepository;
  Idea ideaObject;
//
//    @Override
//    public Idea updateIdea(Idea idea, String ideaId) {
//        return ideaRepository.findOne(ideaId);
//    }
@Autowired
private RabbitTemplate rabbitTemplate;

    @Value("${javainuse.idea.exchange}")
    String ideaExchange;

    @Value("${javainuse.idea.routingkey}")
    String ideaRoutingkey;

    @Autowired
  public IdeaHubServiceImpl(IdeaHubRepository ideaRepository)
  {
    this.ideaHubRepository=ideaRepository;
  }


    //CODE FOR ADDING AN IDEA
  @Override
  public Idea addIdea(Idea idea)
  {
    Idea savedIdea;
    savedIdea = ideaHubRepository.save(idea);
    return savedIdea;
//    if(ideaRepository.existsById(idea.getIdeaId(idea))){
//      throw new IdeaAlreadyExistException("Idea already exist");
//    }
//
//    else{
//    savedIdea = ideaRepository.save(idea);
//      if(savedIdea == null){
//        throw new IdeaNull("Enter Idea");
//      }
//  }
  }


    //CODE FOR DELETING AN IDEA
  @Override
  public void deleteIdea(String ideaId) {
    ideaHubRepository.deleteById(ideaId);

  }




    //CODE FOR UPDATING AN IDEA
  @Override
  public Idea updateIdea(Idea idea) {
      Idea ideaNew = new Idea();
      System.out.println("in update");
      if (ideaHubRepository.existsById(idea.getIdeaId())) {
//      if (Objects.isNull(idea)) {

          System.out.println("It exists");
          ideaNew=ideaHubRepository.save(idea);

//          handle this exception using {@link RestExceptionHandler}
//          throw new EntityNotFoundException(Idea.class, ideaId);
//      }


//          ideaNew= ideaRepository.save(idea);
      }

      return ideaNew;
  }



    //CODE FOR DISPLAYING AN IDEA
  @Override
  public List<Idea> displayIdea() {
    return ideaHubRepository.findAll();
  }



    public void send(Idea idea) {
        rabbitTemplate.convertAndSend(ideaExchange, ideaRoutingkey, idea);
        System.out.println("Send msg = " + idea);
    }

}
