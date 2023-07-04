package kopo.poly.service;

import kopo.poly.dto.UserInfoDTO;
import kopo.poly.persistance.mapper.IUserInfoMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserInfoService implements IUserInfoService {
    private final IUserInfoMapper userInfoMapper;

    @Override
    public UserInfoDTO getUserIdExists(UserInfoDTO pDTO) throws Exception {
        return null;
    }

    @Override
    public UserInfoDTO getEmailExists(UserInfoDTO pDTO) throws Exception {
        return null;
    }

    @Override
    public int insertUserInfo(UserInfoDTO pDTO) throws Exception {
        log.info(this.getClass().getName() + ".insertUserInfo Start!");

        int res = 0;

        res = userInfoMapper.insertUserInfo(pDTO);

        log.info(this.getClass().getName() + ".insertUserInfo End!");

        return res;
    }

    @Override
    public UserInfoDTO getLogin(UserInfoDTO pDTO) throws Exception {
        return null;
    }

    @Override
    public UserInfoDTO searchUserIdOrPasswordPrac(UserInfoDTO pDTO) throws Exception {
        return null;
    }

    @Override
    public int newPasswordProc(UserInfoDTO pDTO) throws Exception {
        return 0;
    }
}
