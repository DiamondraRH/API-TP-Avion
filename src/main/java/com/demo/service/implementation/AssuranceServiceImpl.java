package com.demo.service.implementation;

import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import com.demo.model.Assurance;
import com.demo.repository.AssuranceRepository;
import com.demo.service.AssuranceService;


@Service
public class AssuranceServiceImpl implements  AssuranceService {

    public final AssuranceRepository assuranceRepository;
      
    public AssuranceServiceImpl(AssuranceRepository assuranceRepository) {
        this.assuranceRepository = assuranceRepository;
    }

    @Override
    public Assurance creer(Assurance assurance) {
    // TODO Auto-generated method stub
    return assuranceRepository.save(assurance);
    }
    

    @Override
    public ArrayList<Assurance> lire() {
        // TODO Auto-generated method stub
       return (ArrayList<Assurance>) assuranceRepository.findAll();
    }

    /* (non-Javadoc)
     * @see com.demo.service.AssuranceService#modifier(int, com.demo.model.Assurance)
     */
    @Override
    public Assurance modifier( Assurance assurance) {
        List<Assurance> list = assuranceRepository.findExpired1Month();
        Assurance a = new Assurance();
        if(!list.isEmpty()){
            for(int i=0;i<list.size();i++){
                list.get(i).setId(assurance.getId());
                list.get(i).setAvion(assurance.getAvion());
                list.get(i).setDateExpiration(assurance.getDateExpiration());
                list.get(i).setDateObtention(assurance.getDateObtention());
                a  = list.get(i);
            }
        }else{
            new RuntimeException("Non valide");
        }
        return a;
    
      
    }

    @Override
    public String supprimer(int id) {
        // TODO Auto-generated method stub
        assuranceRepository.deleteById(id);
        return "suppression assurance ok";

    }



    @Override
    public  List <Assurance> findExpired1Month() {
        // TODO Auto-generated method stub
        return assuranceRepository.findExpired1Month();
    }

    public  List <Assurance> findExpired3Month() {
        // TODO Auto-generated method stub
        return assuranceRepository.findExpired3Month();
    }

    public Assurance findByIdAvion(int idAvion) {
        return assuranceRepository.findByIdAvion(idAvion);
    }
}
