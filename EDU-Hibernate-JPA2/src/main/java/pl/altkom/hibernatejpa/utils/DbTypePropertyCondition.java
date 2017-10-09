//package pl.altkom.hibernatejpa.utils;
//
//import org.springframework.context.annotation.Condition;
//import org.springframework.context.annotation.ConditionContext;
//import org.springframework.core.type.AnnotatedTypeMetadata;
//
//public class DbTypePropertyCondition implements Condition {
//
//	@Override
//	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
//		String dbType = context.getEnvironment().getProperty("app.dbType");
//				 return "H2".equalsIgnoreCase(dbType);
//	}
//
//}
