package lk.ijse.cmjd108.Lost_and_Found.util;

import org.springframework.stereotype.Component;

import lk.ijse.cmjd108.Lost_and_Found.config.UserDetailsImpl;
import lombok.Value;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expirationMs}")
    private long expirationMs;

    public String generateToken(UserDetailsImpl userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .claim("role", userDetails.getAuthorities().iterator().next().getAuthority())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean isTokenValid(String token, UserDetailsImpl userDetails) {
        String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        Date expiration = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getExpiration();
        return expiration.before(new Date());
    }
}
