package personal.skyxt.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT工具类
 * @author skyxt
 * Created 2019-07-16 09:37
 * Email skyxt.yang@gmail.com
 */
public class JwtUtils {

    private static final long EXPIRE_TIME = 1 * TimeUtils.DAY_MILLIS;
    private static final String TOKEN_SECRET = "w0qe213j12k41jh1ivj0aj2j24j";

    private JwtUtils() {}

    /**
     * 签名
     * @param data
     *          签名数据
     * @return
     *          签名后的字符串
     */
    public static String sign(final Map<String, String> data) {
        final HashMap<String, Object> header = new HashMap<>(2);
        header.put("typ", "JWT");
        header.put("alg", "HS256");
        final JWTCreator.Builder builder = JWT.create().withHeader(header);
        if (!CollectionUtils.isBlank(data)) {
            data.forEach((k, v) -> builder.withClaim(k, v));
        }

        return builder.withExpiresAt(new Date(System.currentTimeMillis() + EXPIRE_TIME)).sign(Algorithm.HMAC256(TOKEN_SECRET));
    }

    /**
     * 验证签名
     * @param token
     *          需要验证的数据
     * @return
     *          是否通过验证
     */
    public static boolean verify(final String token) throws Exception {
        boolean verify;

        try {
            final Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            final JWTVerifier verifier = JWT.require(algorithm).build();
            final DecodedJWT jwt = verifier.verify(token);
            verify = jwt.getExpiresAt().getTime() >= System.currentTimeMillis();
        } catch (Exception e) {
            throw new Exception(String.format("the verified token is invalid: [token:%s]", token), e);
        }

        return verify;
    }

    public static Map<String, Claim> getClaims(final String token) {
        final DecodedJWT decode = JWT.decode(token);
        final Map<String, Claim> claims = decode.getClaims();

        return claims;
    }
}
