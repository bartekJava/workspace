@org.hibernate.annotations.GenericGenerator(
 name = "ID_GENERATOR",
 strategy = "enhanced-sequence",
 parameters = {
 @org.hibernate.annotations.Parameter(
 name = "sequence_name",
 value = "EDU-Hibernate-JPA2_SEQUENCE"
 ),
 @org.hibernate.annotations.Parameter(
 name = "initial_value",
 value = "1"
 )
})

package pl.altkom.hibernatejpa.model;