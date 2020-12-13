package in.ems.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {
	@Value("${app.jwt.secretKey}")
	private String secret;
	
	@Value("${app.jwt.expiration}")
	private int expiration;
	
	public String generateToken(Authentication auth) {
		UserPrincipal userPrincipal = (UserPrincipal) auth.getPrincipal();
		Date currentDate = new Date();
		Date expiryDate = new Date(currentDate.getTime() + expiration);
		
		return Jwts.builder().setSubject(userPrincipal.getUserId()).setIssuedAt(currentDate).setExpiration(expiryDate).signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	public String getNameFromJwt(String token) {
		Claims claim = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		return claim.getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		}
		// Change following to logger
		catch(SignatureException ex) {
			System.out.println("Invalid JWT Signature");
		}
		catch(MalformedJwtException ex) {
			System.out.println("Invalid JWT Token");
		}
		catch(ExpiredJwtException ex) {
			System.out.println("Token is expired");
		}
		catch(UnsupportedJwtException ex) {
			System.out.println("Unsupported JWT");
		}
		catch(IllegalArgumentException ex) {
			System.out.println("Empty JWT");
		}
		return false;
	}
}
