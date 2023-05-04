# Assignment_TestVagrant
Create an in-memory store for recently played songs that can accommodate N songs per user, with a fixed initial capacity.

plugins {
    id 'java'
}

group = 'org.example'
version = '1.0-SNAPSHOT'

repositories {
    mavenCentral()
}

dependencies {
    implementation 'junit:junit:4.13.1'
    implementation 'org.testng:testng:7.1.0'
    implementation 'org.testng:testng:7.1.0'
    testImplementation platform('org.junit:junit-bom:5.9.1')
    testImplementation 'org.junit.jupiter:junit-jupiter'
}

test {
    useJUnitPlatform()
}
