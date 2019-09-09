package fa.haint53.service;

import fa.haint53.entities.User;
import fa.haint53.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    @Autowired
    MemberRepository memberRepository;

    public boolean deleteUser(String id) throws Exception {
        if(memberRepository.findById(id)!=null){
            memberRepository.deleteById(id);
            if(memberRepository.findById(id)==null) return true;
            else throw new Exception("Delete fail");
        }
        else{
            throw  new Exception("User is not exist!");
        }
    }
    public User updateUser(User user) throws Exception {
        if(memberRepository.findById(user.getId())!=null){
            System.out.println(user.getId());
           return memberRepository.save(user);
        }
        else{
            throw  new Exception("User is not exist!");
        }
    }

}
