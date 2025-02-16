package net.tanish.journalApp.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Document(collection = "users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    private ObjectId id;
    
    @Indexed(unique = true)
    @NonNull
    private String userName;
    
    private String email;
    private boolean sentimentAnalysis;
    
    @NonNull
    private String password;
    
    @DBRef
    @Builder.Default
    private List<JournalEntry> journalEntries = new ArrayList<JournalEntry>();
    
    @Builder.Default
    private List<String> roles = new ArrayList<>();
}
