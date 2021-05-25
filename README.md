 ```
<properties>
	<java.version>11</java.version>
	<!-- https://mvnrepository.com/artifact/org.mapstruct/mapstruct -->
	<org.mapstruct.version>1.4.2.Final</org.mapstruct.version>
	<!-- https://mvnrepository.com/artifact/org.mapstruct/mapstruct -->
</properties>


 <!-- https://mvnrepository.com/artifact/org.mapstruct/mapstruct -->
<dependency>
	<groupId>org.mapstruct</groupId>
	<artifactId>mapstruct</artifactId>
	<version>${org.mapstruct.version}</version>
</dependency>
<!-- https://mvnrepository.com/artifact/org.mapstruct/mapstruct -->


    
<!-- https://mvnrepository.com/artifact/org.mapstruct/mapstruct -->
		<plugin>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-maven-plugin</artifactId>
		</plugin>
		<plugin>
			<groupId>org.apache.maven.plugins</groupId>
			<artifactId>maven-compiler-plugin</artifactId>
			<configuration>
				<source>${java.version}</source>
				<target>${java.version}</target>
				<annotationProcessorPaths>
					<path>
						<groupId>org.projectlombok</groupId>
						<artifactId>lombok</artifactId>
						<version>${lombok.version}</version>
					</path>
					<path>
						<groupId>org.mapstruct</groupId>
						<artifactId>mapstruct-processor</artifactId>
						<version>1.4.2.Final</version>
					</path>
				</annotationProcessorPaths>
			</configuration>
		</plugin>
		<!-- https://mvnrepository.com/artifact/org.mapstruct/mapstruct -->
```
