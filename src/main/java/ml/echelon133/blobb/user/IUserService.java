package ml.echelon133.blobb.user;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    User findByUuid(UUID uuid) throws UserDoesntExistException;
    boolean followUserWithUuid(User user, UUID followUuid) throws UserDoesntExistException, IllegalArgumentException;
    boolean unfollowUserWithUuid(User user, UUID unfollowUuid) throws UserDoesntExistException;
    List<User> findAllFollowedBy(UUID uuid, Long skip, Long limit) throws UserDoesntExistException, IllegalArgumentException;
    List<User> findAllFollowing(UUID uuid, Long skip, Long limit) throws UserDoesntExistException, IllegalArgumentException;
    UserProfileInfo getUserProfileInfo(UUID uuid) throws UserDoesntExistException;
}
