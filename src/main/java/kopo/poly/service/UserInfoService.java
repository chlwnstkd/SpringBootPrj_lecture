package kopo.poly.service;

import kopo.poly.dto.UserInfoDTO;
import kopo.poly.persistance.mapper.IUserInfoMapper;
import kopo.poly.util.CmmUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserInfoService implements IUserInfoService {
    private final IUserInfoMapper userInfoMapper;

    @Override
    public int insertUserInfo(UserInfoDTO pDTO) throws Exception {
        log.info(this.getClass().getName() + ".insertUserInfo Start!");

//        int res = 0;
//
//        res = userInfoMapper.insertUserInfo(pDTO);

        Optional<UserInfoDTO> rDTO = Optional.ofNullable(
                userInfoMapper.getUserIdExists(pDTO));

        int res = 0;
        if(!rDTO.isPresent()) {
            res = userInfoMapper.insertUserInfo(pDTO);
        } else {
            res = 2;
        }

        log.info(this.getClass().getName() + ".insertUserInfo End!");

        return res;
    }

    @Override
    public UserInfoDTO getLogin(UserInfoDTO pDTO) throws Exception {
        log.info(this.getClass().getName() + ".getLogin Start!");
        UserInfoDTO rDTO = Optional.ofNullable(userInfoMapper.getLogin(pDTO)).orElseGet(UserInfoDTO::new);
        //위 코딩은 코드가 줄어들지만 가독성이 떨어진다
        //그래서 가독성을 위해 아래와 같이 코딩할 수도 있다
        //UserInfoDTO rDTO = userInfoMapper.getLogin(pDTO);
        //if(rDTO == null)
        //  rDTO = new UserInfoDTO();
        if (CmmUtil.nvl(rDTO.getUser_id()).length() > 0) {
            log.info("로그인 성공");
        }
        //Cmmutil.nvl은 들어온 값이 null이면 빈 문장으로 바꾼다. 아마도 ""로 바뀌는 듯
        //그래서 길이도 0
        log.info(this.getClass().getName() + ".getLogin End!");
        return rDTO;
    }

}
