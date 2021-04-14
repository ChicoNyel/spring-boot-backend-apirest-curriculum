package springbootbackendapirestcurriculum.auth;

public class JwtConfig {

	public static final String LLAVE_SECRETA = "alguna.clave.secreta.12345678";
	
	public static final String RSA_PRIVADA = "-----BEGIN RSA PRIVATE KEY-----\r\n" + 
			"MIIEpAIBAAKCAQEA0kuVbEXXsXgMTbqLwN4ucdYfUiAhKbFUaPB21KuvcBC1XZJP\r\n" + 
			"dlfbecC4/b7yZR4NKMJJAtyvSmF1pMxv8lPRaEqmVLOCussWJ5qPlYuugVum3K0h\r\n" + 
			"p1iTbMd/Ejny4pahHCQ7raVhK/ZujidyJn2EUGBoZi6dsJs6H8CZoi2SHqRBQlaa\r\n" + 
			"k9n6iX42omW+/c4atbhqI1jpsrXizb2jPGT9WoSnQu813s8jLHmT5613jv/7jZHk\r\n" + 
			"3JI/iLE190qwwd/bZkYUwRopGiaCToLy8VYdqYgdtRYAQBzyRT0tNcXe45hV1iCy\r\n" + 
			"m3J99uu3ZuQEEOEeEg8fi2ifEpo+5ZwXNbXadQIDAQABAoIBAFQnbwo/AMvCEJpi\r\n" + 
			"Vl6+CrP/TdVdiifXEMJVyBffBHvCE/H4BNiE3A1i9CSG7xVL61QuO21rxrHrQlrK\r\n" + 
			"fNnqdNhZVyp6E4yQjLMYhPEBTrnxZVrV5avEJGrZgp5Wlj3arWpHjaI1licznJZC\r\n" + 
			"bsm8XOCVU/HgIbZ0x9PBDTn7Jogf1NMk2ecnpnExHzHvbGRJI8oNAgZmH9SAiCpj\r\n" + 
			"nVjAXC80k4p7/1Vl/8c7F2PJ3oG0AUCrPyfhX/bH/9vhvhgKJGJx9r+CvSqygzoz\r\n" + 
			"pb36bSatQJT1TuHhSCEwyOUK0nxlxAjKKrnHWpSHiXPe0Z9DYEmQIkwfGcm4P7L9\r\n" + 
			"daD53pkCgYEA+Zmbo/NiMOVHRQa7/ipQ4izs7fggoDgxECxyLcy0d3kj2Vk1B5gY\r\n" + 
			"qzBDGIpqJdXD3T65k2E/otVbze8avT6xSeCLd0yobxPjUZvZhPJkv0B9uFCPNLow\r\n" + 
			"oWwAeImeI4zCjNIlJL7X6qHGI+JJhA0jUWciGlpTaROEt8WlZerJN68CgYEA16/5\r\n" + 
			"89/DvAumUQY2IxsVSB8NeIEeLtz3w/CoBJyOLG6Y57EnvlHn3nKH55bNp1CbsReI\r\n" + 
			"Vfr+0pTW88Gn7/sgZBFo67nkJF6f+1/qncB4BlVCoOBDDZh3zgXgXOuHQrJzxwnR\r\n" + 
			"Y9l/unoBG7Got6w7N5V3Zd1+L1TJuioVpj0WdRsCgYBsJqfu4W2hfCdmfGWG2vUT\r\n" + 
			"G55J+qLAabiwpmGPAM0Nm5rx+ZplwPynaJEaGBeobzigLCai+pdlSgeucrVmXLzb\r\n" + 
			"IwWrWrb88mQkH2CgH5uR1zLiY1253hdmSnLlx9OS2dIOzJu1kU/jZdeCAvIR2tN7\r\n" + 
			"2TFIs+zCceem7Wgegh5QFwKBgQCwNf75NOjOqp3YOEDmcWvznhr9Rk+IbdKl6+j4\r\n" + 
			"y4aD2l9leqBDptrOK7fIhrXBaeOozNb/l620ERGD18UCFKKj3m1fmGFBLWV6kyQ0\r\n" + 
			"eVgVpHZoxI9DfjrywG5Ku8mnve9Ev0qoTrtBeAeLvpteY4GFqcEAIfLDbHvaciN5\r\n" + 
			"yxKb3QKBgQDlFsJQLCPtApmcfxtY6MnCPygvlpbcAvTOXMoTOtOq028nDHlDOaFA\r\n" + 
			"0NpFuZs8fPzXjUWXtCS/vutJAaENYTVY/BmyaR67xP5hDQ6PjCVEUYTYG7Anwy9F\r\n" + 
			"CLY0mvjp3taGCgJQmF/gH9vSco05t3/UBun/zNLTZB+RM3/LU0d1KQ==\r\n" + 
			"-----END RSA PRIVATE KEY-----";
	
	public static final String RSA_PUBLICA = "-----BEGIN PUBLIC KEY-----\r\n" + 
			"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA0kuVbEXXsXgMTbqLwN4u\r\n" + 
			"cdYfUiAhKbFUaPB21KuvcBC1XZJPdlfbecC4/b7yZR4NKMJJAtyvSmF1pMxv8lPR\r\n" + 
			"aEqmVLOCussWJ5qPlYuugVum3K0hp1iTbMd/Ejny4pahHCQ7raVhK/ZujidyJn2E\r\n" + 
			"UGBoZi6dsJs6H8CZoi2SHqRBQlaak9n6iX42omW+/c4atbhqI1jpsrXizb2jPGT9\r\n" + 
			"WoSnQu813s8jLHmT5613jv/7jZHk3JI/iLE190qwwd/bZkYUwRopGiaCToLy8VYd\r\n" + 
			"qYgdtRYAQBzyRT0tNcXe45hV1iCym3J99uu3ZuQEEOEeEg8fi2ifEpo+5ZwXNbXa\r\n" + 
			"dQIDAQAB\r\n" + 
			"-----END PUBLIC KEY-----";
	
}
