package com.github.wirye.lrclibkt

import com.github.wirye.lrclibkt.model.decipherSyncedLyrics
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertTrue

class RealApiIntegrationTest {
    private val client = LrclibClient()

    @Test
    fun `search by meta`() = runTest {
        val result = client.search.searchByMeta(
            trackName = "Serenade",
            artist = "natori",
        )

        println(">>> Result isSuccess: ${result.isSuccess}")
        println(">>> Result: $result")
        println(">>> Exception type: ${result.exceptionOrNull()?.javaClass?.simpleName}")
        println(">>> Exception message: ${result.exceptionOrNull()?.message}")

        assertTrue(result.isSuccess)
    }

    @Test
    fun `search by id`() = runTest {
        val result = client.search.searchById(id = 33510328)

        println(">>> Result isSuccess: ${result.isSuccess}")
        println(">>> Result: $result")
        println(">>> Exception type: ${result.exceptionOrNull()?.javaClass?.simpleName}")
        println(">>> Exception message: ${result.exceptionOrNull()?.message}")

        assertTrue(result.isSuccess)
    }

    @Test
    fun `decipher synced lyrics`() = runTest {
        val result = decipherSyncedLyrics("[00:09.00] Tsugou no ii omoi wo moyashite\n" +
                "[00:12.63] Akireta negai wa mou tebanashita\n" +
                "[00:16.17] Uragiri ya himitsu ga tadayotte\n" +
                "[00:19.67] Koko kara ugokenai\n" +
                "[00:22.73]  \n" +
                "[00:22.74] Umarete shimatta, aruiha kowarete shimatta\n" +
                "[00:25.64] Ano hi ano basho de zutto, tomatta mama de ita mirai\n" +
                "[00:29.58] Sore demo, kokoro no doko ka de kimi wo kanjiteita\n" +
                "[00:33.28] Yurusenai, ima no boku wa dare?\n" +
                "[00:36.47]  \n" +
                "[00:36.48] Nee, zutto zutto soba ni itanda \"Kanchigaida\" tte, uso janaiyo\n" +
                "[00:40.83] Nozonda mono janakutomo\n" +
                "[00:43.42] Anata ni deaeta itami dake ga\n" +
                "[00:47.10] Ai datte shinjirareru you ni\n" +
                "[00:49.83]  \n" +
                "[00:49.84] Boku ni furenaide! Inoru, serenaade\n" +
                "[00:53.58] Boku nashide umaku shiawase ni natte ne\n" +
                "[00:57.12] Dare yori mo zutto, nani wo tebanashite mo\n" +
                "[01:00.38] Kore ga ai datte shinjiteita, bachi wo kudasai\n" +
                "[01:06.02]  \n" +
                "[01:06.03] Dare de mo nai, anata, anata dake\n" +
                "[01:09.16] Sеkai ga mada wasurete kurenakutе mo\n" +
                "[01:12.83] Kitto, mada anata, anata dake\n" +
                "[01:16.20] Negai tsukarete mo utauyo, serenaade\n" +
                "[01:23.32] Negai tsukarete mo utauyo, serenaade\n" +
                "[01:28.53]  \n" +
                "[01:28.54] Shinari odoori no komedi fukou jiman wa haumenii?\n" +
                "[01:32.37] Egoisutikku ni hikatta hitomi no naka ni utsutteiru\n" +
                "[01:35.27] \"Anata\" wa \"dare?\" kurayami ga hikaraseta butai no ue de\n" +
                "[01:37.62] Nani mo shirazu ni tada odotte iraretanara yokatta\n" +
                "[01:41.97]  \n" +
                "[01:41.98] Kibou mo, fukou mo migatteda bokura wa, zenin kyou hansha datta\n" +
                "[01:46.15] Utagau yochi mo nai hodo\n" +
                "[01:48.92] Unmei ga sadamatta, ano yoru kara\n" +
                "[01:51.89] Boku wa aishi kata wo wasureta\n" +
                "[01:55.91]  \n" +
                "[01:55.92] Kore dake negatte, kore dake inotte\n" +
                "[01:59.22] Konna, kanashii ketsumatsu de gomenne\n" +
                "[02:02.78] Subete ushinatte, subete kiesatte mo\n" +
                "[02:06.38] Tada, kimi ga zutto ikiteita itami ga hoshii\n" +
                "[02:25.01]  \n" +
                "[02:25.02] 「Ato, nan kai kazoetara, ato, nan kai kizutsukeba」\n" +
                "[02:28.44]  \n" +
                "[02:28.45] 「Ato, nan kai ushinaeba, ato, nan kai kowaretara」\n" +
                "[02:31.91]  \n" +
                "[02:31.92] 「Ato, nan kai kazoetara, ato, nan kai kizutsukeba」\n" +
                "[02:35.49]  \n" +
                "[02:35.50] 「Ato, nan kai ushinaeba-                          \u200E \n" +
                "[02:37.32]  \n" +
                "[02:37.33] 「kono omoi wa mitasareru?」\n" +
                "[02:39.53]  \n" +
                "[02:39.54] Kore dake negatte, kore dake inotte\n" +
                "[02:43.16] Konna, kanashii ketsumatsu de gomenne\n" +
                "[02:46.61] Subete ushinatte, subete ga chigatte mo\n" +
                "[02:50.15] Tada, boku ga zutto aishiteita\n" +
                "[02:53.14] Kimi yo kienaide! Inoru, serenaade\n" +
                "[02:57.19] Boku nashide umaku shiawase ni nattene\n" +
                "[03:00.73] Dare yori mo zutto, nani wo tebanashite mo\n" +
                "[03:04.15] Kore ga ai datte shinjiteita, bachi wo kudasai\n" +
                "[03:09.51]  \n" +
                "[03:09.52] Dare de mo nai, anata, anata dake\n" +
                "[03:12.85] Sekai ga mada wasurete kurenakute mo\n" +
                "[03:16.44] Kitto, mada anata anata dake\n" +
                "[03:19.76] Negai tsukarete mo utauyo, serenaade\n" +
                "[03:27.10] Ame ga ori satte mo, boku janakutatte\n" +
                "[03:30.47] Negai tsukarete mo utauyo, serenaade...\n" +
                "[03:39.69]  ))")

        println(result)
    }
}
